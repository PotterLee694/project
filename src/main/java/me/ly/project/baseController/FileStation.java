package me.ly.project.baseController;

import lombok.extern.slf4j.Slf4j;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@Slf4j
public class FileStation {
    @PostMapping("/upload")
    public String upload(HttpServletRequest req, MultipartHttpServletRequest multiReq) throws IOException, MimeTypeException {
        String contentType = multiReq.getFile("file").getContentType();
        String classpath = ResourceUtils.getURL("classpath:").getPath();
        String suffix = MimeTypes.getDefaultMimeTypes().forName(contentType).getExtension();

        String filename = System.currentTimeMillis() + suffix;
        String path = classpath + "static/res/" + filename;
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        FileInputStream fs = (FileInputStream) multiReq.getFile("file").getInputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        while ((len = fs.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        fs.close();
        log.info("upload<-{}", filename);
        return "http://localhost:8081/res/" + filename;
    }
}
