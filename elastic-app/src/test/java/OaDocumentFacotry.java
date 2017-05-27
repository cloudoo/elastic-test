import com.csair.bi.oasearch.domain.Attachment;
import com.csair.bi.oasearch.domain.Document;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cloudoo on 2017/5/26.
 */
public class OaDocumentFacotry {
    public static String fileSuffs="doc,docx,mht,pdf,ppt,rtf,txt,xls";

    public List<String> getTempDocUrl(String url){
        List<String> urls = new ArrayList<String>();

        File docDir = new File(url);
        if(docDir.isDirectory()){
            File[] files = docDir.listFiles();
            for(File file:files){
                if(file.isDirectory()){
                    if(fileSuffs.indexOf(file.getName())>=0){

                        File[] tempF = file.listFiles();
                        for(File t:tempF){
                            urls.add(t.getAbsolutePath());
                        }


                    }
                }
            }
        }

        return urls;
    }

    public List<Attachment> getAttachmentDateFromFile() {
        List<Attachment> attachmentList = new ArrayList<Attachment>();
        File docFile = new File("D:\\03_工作文件\\02_研究院\\01_项目\\07_管研需求\\01_OA项目组\\demo2.csv");

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try {
            fis = new FileInputStream(docFile);
            isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);

            String line = "";
            String tempLine = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                String lines[] = line.split(",");
                if (count >= 1) {
                    Attachment attachment = new Attachment();
                    attachment.setDocId(Long.parseLong(lines[0]));
                    attachment.setAttachId(Long.parseLong(lines[1]));
                    attachment.setName(lines[2]);
                    attachment.setUrl(lines[3]);
                    attachment.setType(lines[4]);
                    if (StringUtils.isNotEmpty(lines[5])) {
                        try {
                            Date date = simpleDateFormat.parse(lines[5]);
                            Timestamp timestamp = new Timestamp(date.getTime());
                            attachment.setUpTm(timestamp);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }


                    }
                    attachmentList.add(attachment);
                }

                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return attachmentList;
    }
    public void getDateFromFile(){

        List<Document> documentList = new ArrayList<Document>();


        File docFile = new File("D:\\03_工作文件\\02_研究院\\01_项目\\07_管研需求\\01_OA项目组\\demo1.csv");

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fis = new FileInputStream(docFile);
            isr = new InputStreamReader(fis, "UTF-8");
            br = new BufferedReader(isr);

            String line = "";
            String tempLine = "";
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count > 1 ) {

                    //
                    Document document = new Document();
                    String[] lines = line.split(",");
                    document.setId(Long.parseLong(lines[0]));
                    document.setCategory(lines[1]);
                    document.setDocYear(Integer.parseInt(lines[2]));
                    document.setAttachEnumerate(lines[3]);
                    try {
                        if (StringUtils.isNotBlank(lines[4])) {
                            document.setDocDate(simpleDateFormat.parse(lines[4]));
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if (StringUtils.isNotBlank(lines[5])){
                        document.setDeptId(Integer.parseInt(lines[5]));
                    }

                    document.setDeptName(lines[6]);

//                    document.setSecret(Integer.parseInt(lines[]));
                    if(StringUtils.isNotBlank(lines[7])){
                        document.setFlag(Integer.parseInt(lines[7]));
                    }
                    if(StringUtils.isNotBlank(lines[8])) {
                        document.setArchiveNo(lines[8]);
                    }

                    document.setCreateTime(lines[9]);
                    document.setCreateUser(lines[10]);
                    document.setUpdateTm(lines[11]);
                    document.setUpdateUser(lines[12]);
                    document.setExpireDestoryDate(lines[13]);
                    document.setAnnualYear(lines[14]);
                    if(StringUtils.isNotBlank(lines[15])) {
                        document.setVersionId(Long.parseLong(lines[15]));
                    }
                    document.setRemark(lines[16]);


                    documentList.add(document);

                }
                count++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert br != null;
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }
}
