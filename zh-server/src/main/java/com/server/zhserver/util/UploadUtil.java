package com.server.zhserver.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/***
 * Created by dz on 2019-12-4
 */
public class UploadUtil {

    /***
     * 文件上传
     * @param file
     * @param uploadName
     * @return 文件存储路径
     */
    public static String upload(String uploadName, MultipartFile file, String savePath) throws IOException {
        if (!"".equals(uploadName) && uploadName!=null) {
            UUID randomUUID = UUID.randomUUID();
            String newFileName = randomUUID.toString() + "_" +DateUtil.getDateStr()+ uploadName;
            String saveFilePath = savePath + "\\" + newFileName;
            file.transferTo(new File(saveFilePath));
            return saveFilePath;
        }
        return "";
    }
}
