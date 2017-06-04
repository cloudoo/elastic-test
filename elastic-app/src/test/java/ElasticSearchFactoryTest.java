import com.csair.bi.es.ElasticSearchFactory;
import com.csair.bi.oasearch.domain.Attachment;
import com.csair.bi.oasearch.domain.Document;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cloudoo on 2017/5/25.
 */
public class ElasticSearchFactoryTest {

    @Test
    public void test2(){
        ElasticSearchFactory elasticSearchFactory = new ElasticSearchFactory();
        String index ="my_index";
        String type="my_type";
        long id = 31;
        String pipeline = "attachment";
        String filePath = "S:\\oa_search\\txt\\JAVA开发环境配置步骤.txt";//2
        filePath = "S:\\oa_search\\txt\\LICENSE.sax.txt";// txt中文ingest 会有问题
//          filePath = "S:\\oa_search\\pdf\\60477505.pdf";//3
        filePath = "S:\\\\oa_search\\\\pdf\\\\60478869.pdf";//31

//        filePath = "D:\\03_工作文件\\02_研究院\\01_项目\\00_大数据平台\\00_项目文档\\12_外包\\月度工作绩效评价表-大数据项目组-5月份(1).xls";//4
//       filePath = "S:\\oa_search\\wps\\16022200568_5.wps"; //5
//        filePath = "S:\\oa_search\\doc\\60548130.doc";//6
//        filePath = "S:\\oa_search\\docx\\15121700818_12.docx";//7
//        filePath = "S:\\oa_search\\ppt\\1507657.ppt";//8
//        filePath = "S:\\oa_search\\rtf\\1202081.rtf";//9
//        filePath = "S:\\oa_search\\tif\\15102800589_7.tif";//10 无法解析

        filePath = "/Users/cloudpj/Desktop/20161012-数据挖掘课程/学员资料/参考书籍/153分钟学会R.pdf";
        String test = elasticSearchFactory.indexDocument(index,type,pipeline,id,filePath);

        System.out.print(test);
    }
    @Test
    public void test() {

        ElasticSearchFactory elasticSearchFactory = new ElasticSearchFactory();

            Document doc = new Document();

            doc.setId(1234);
            doc.setCategory("测试");

//        elasticSearchFactory.index();
            OaDocumentFacotry test = new OaDocumentFacotry();

            List<Attachment> attachmentList = test.getAttachmentDateFromFile();
            List<String> urls = test.getTempDocUrl("S:\\oa_search");

            List<Attachment> testAtts = new ArrayList<Attachment>();
            for (int i = 0; i < urls.size(); i++) {
                Attachment att = attachmentList.get(i);
                att.setUrl(urls.get(i));
                testAtts.add(att);
        }

        System.out.println(testAtts.size());
        try {
            for (Attachment tempatt : testAtts) {
                elasticSearchFactory.index(tempatt, "oa_file", "attachfile");
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


}
