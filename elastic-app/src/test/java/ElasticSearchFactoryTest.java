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
        long id = 3;
        String filePath = "S:\\oa_search\\pdf\\60477505.pdf";

        String test = elasticSearchFactory.indexDocument(index,type,id,filePath);
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
