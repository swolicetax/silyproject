package com.swjsj.searcher;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;

public class SearchUtils {
	private static IndexWriterConfig config = new IndexWriterConfig(
			Version.LUCENE_36, new StandardAnalyzer(Version.LUCENE_36));

	private static Directory directory = null;

	private static IndexReader reader = null;

	public void index() {
		IndexWriter iw = null;
		try {
			iw = new IndexWriter(directory, config);
			iw.deleteAll();
			Document doc = null;
			File[] files = new File("h:/logs").listFiles();
			Random r = new Random();
			int id = 0;
			for (File file : files) {
				doc = new Document();
				int sorce = r.nextInt(200);
				doc.add(new Field("id",String.valueOf(id++),Field.Store.YES,Field.Index.NOT_ANALYZED_NO_NORMS));
				doc.add(new Field("content", new FileReader(file)));
				doc.add(new Field("filename", file.getName(), Field.Store.YES,
						Field.Index.NOT_ANALYZED));
				doc.add(new Field("path", file.getAbsolutePath(),
						Field.Store.YES, Field.Index.NOT_ANALYZED));
				doc.add(new NumericField("size",Field.Store.YES,true).setDoubleValue(file.length()));
				doc.add(new NumericField("date",Field.Store.YES,true).setLongValue(file.lastModified()));
				doc.add(new NumericField("score",Field.Store.YES,true).setIntValue(sorce));
				iw.addDocument(doc);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				iw.close();
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public SearchUtils() {
		try {
			directory = FSDirectory.open(new File(
					"H:/workspace2/lucene/indexs02"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public SearchUtils(Directory directory) {
			this.directory = directory;
	}

	public IndexSearcher getIndexSearcher() {
		try {
			if (reader == null) {
				reader = IndexReader.open(directory);
			} else {
				IndexReader ir = reader.openIfChanged(reader);
				if (ir != null) {
					if (reader != null) {
						reader.close();
					}
					reader = ir;
				}
			}
			IndexSearcher is = new IndexSearcher(reader);
			return is;
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void SearchByQueryParse1() {
		IndexSearcher is = getIndexSearcher();
		try {
			QueryParser qp = new QueryParser(Version.LUCENE_36, "content",
					new StandardAnalyzer(Version.LUCENE_36));
			Query query = qp.parse("jishijun204");
			TopDocs tp = is.search(query, 10);
			ScoreDoc[] sd = tp.scoreDocs;
			for (ScoreDoc scoreDoc : sd) {
				Document doc = is.doc(scoreDoc.doc);
				System.out.println(doc.get("path") + " 文件名："
						+ doc.get("filename"));
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void SearchByQueryParse2(Query query) {
		IndexSearcher is = getIndexSearcher();
		try {
			TopDocs tp = is.search(query, 100);
			ScoreDoc[] sd = tp.scoreDocs;
			for (ScoreDoc scoreDoc : sd) {
				Document doc = is.doc(scoreDoc.doc);
				System.out.println(doc.get("path") + " 文件名："
						+ doc.get("filename"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void searchNoPage(Query query) {
		IndexSearcher is = getIndexSearcher();
		try {
			TopDocs tp = is.search(query, 100);
			System.out.println("多少个索引:" + tp.totalHits);
			ScoreDoc[] sd = tp.scoreDocs;
			for (int i = 0; i < sd.length; i++) {
				Document doc = is.doc(sd[i].doc);
				System.out.println("doc.id" + sd[i].doc + "----->"
						+ doc.get("path") + " 文件名：" + doc.get("filename"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void searchByPage1(Query query, int pageIndex, int pageSize) {
		IndexSearcher is = getIndexSearcher();
		try {
			TopDocs tp = is.search(query, 100);
			ScoreDoc[] sd = tp.scoreDocs;
			int end = sd.length < pageIndex * pageSize ? sd.length : pageIndex
					* pageSize;
			int start = (pageIndex - 1) * pageSize;
			if (end < start) {
				throw new Exception("索引的数据小于要查询的数据数");
			}
			for (int i = start; i < end; i++) {
				Document doc = is.doc(sd[i].doc);
				System.out.println("doc.id" + sd[i].doc + "----->"
						+ doc.get("path") + " 文件名：" + doc.get("filename"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ScoreDoc getScoreDoc(Query query, int pageIndex, int pageSize) {
		if (1 == pageIndex) {
			return null;
		}
		IndexSearcher is = getIndexSearcher();
		int req_num = (pageIndex - 1) * pageSize;
		TopDocs tp;
		try {
			tp = is.search(query, req_num);
			if (tp.totalHits<=req_num) {
				throw new Exception("索引的数据小于要查询的数据数");
			}
			ScoreDoc[] sds = tp.scoreDocs;
			return sds[req_num - 1];
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void searchByPage2(Query query, int pageIndex, int pageSize) {
		IndexSearcher is = getIndexSearcher();
		try {
			TopDocs tp = is.searchAfter(getScoreDoc(query,pageIndex,pageSize), query, pageSize);
			ScoreDoc[] sd = tp.scoreDocs;
			int end = sd.length < pageIndex * pageSize ? sd.length : pageIndex
					* pageSize;
			int start = (pageIndex - 1) * pageSize;
			if (end < start) {
				throw new Exception("索引的数据小于要查询的数据数");
			}
			for (int i = start; i < end; i++) {
				Document doc = is.doc(sd[i].doc);
				System.out.println("doc.id" + sd[i].doc + "----->"
						+ doc.get("path") + " 文件名：" + doc.get("filename"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public void searchByContent(String name){
		MultiFieldQueryParser qp = new MultiFieldQueryParser(Version.LUCENE_36, new String[]{"filename","content"},
				new MMSegAnalyzer());
		try {
			Directory dir = FSDirectory.open(new File("H:/workspace2/lucene/indexs03"));
			IndexSearcher is = new SearchUtils(dir).getIndexSearcher();
			Query query = qp.parse(name);
			TopDocs td = is.search(query, 10);
			Document doc = null;
			for (ScoreDoc sd : td.scoreDocs) {
				doc = is.doc(sd.doc);
				String tilte = doc.get("filename");
				tilte = highligh02(query, "filename", tilte);
				System.out.println(doc.get("path"));
				String content = new Tika().parseToString(new File(doc.get("path")));
				content = highligh02(query, "content", content);
				System.out.println(content);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InvalidTokenOffsetsException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String highligh02(Query query,String field,String txt) throws IOException, InvalidTokenOffsetsException{
		QueryScorer scorer = new QueryScorer(query);
		Fragmenter f = new SimpleSpanFragmenter(scorer);
		Highlighter hl = new Highlighter(scorer);
		hl.setTextFragmenter(f);
		return hl.getBestFragment(new MMSegAnalyzer(), field, txt);
	}
	
	
	
	public void highlight01(){
		String str ="阿里鸡丝豆腐垃圾死对方了解拉萨江东父老lajsldfjlasdjflsjdflajsdfljsdfljlsjad撒旦发射点发";
		QueryParser qp = new QueryParser(Version.LUCENE_36, "f",
				new MMSegAnalyzer());
		try {
			Query query = qp.parse("了解 江东");
			QueryScorer scorer = new QueryScorer(query);
			Fragmenter f = new SimpleSpanFragmenter(scorer);
			Highlighter hl = new Highlighter(scorer);
			hl.setTextFragmenter(f);
			System.out.println(hl.getBestFragment(new MMSegAnalyzer(), "f", str));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidTokenOffsetsException e) {
			e.printStackTrace();
		}
	}

}