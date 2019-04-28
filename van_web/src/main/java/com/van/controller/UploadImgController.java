//package com.van.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.UUID;
//
//@Controller
//@RequestMapping("/upload")
//public class UploadImgController {
//
//    @RequestMapping(value = "/up_img", method = RequestMethod.POST)
//    public @ResponseBody
//    String up_img(HttpServletRequest request) throws Exception {
//
//        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//
//        MultipartFile multipartFile = multiRequest.getFile("image");
//
//        String uploadfilepath = request.getServletContext().getRealPath("/upload");
//        File uploadfile = new File(uploadfilepath);
//        if (!uploadfile.exists()) {
//            uploadfile.mkdirs();
//        }
//        String suffix = multipartFile.getOriginalFilename().split("\\.")[1];
//        String filename = UUID.randomUUID().toString() + "." + suffix;
//        String total_path = uploadfilepath + "\\" + filename;
//
//        FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(new File(total_path)));
//
//        String imgURL = "http://localhost:8080/TestSSM01_war_exploded/upload/"+filename;
//        String returnjson="{\"imgURL\":\""+imgURL+"\"}";
//        System.out.println(total_path);
////        model.addAttribute("imgURL",imgURL);
////        model.addAttribute("totalpath",total_path);
////        return "upload_img";
//        return  returnjson;
//
//    }
//
//
//
//
//
//
//
//
//    /**
//     * @return
//     */
//    @RequestMapping(value = "/huoimg")
//    public  String  huoimg(Model model) throws IOException {
//        System.out.println("1111111");
//        String imgURL = "http://localhost:8080/TestSSM01_war_exploded/upload/ceded3a6-62c7-4721-bc65-252aee8ca056.png";
////        String returnjson="{\"imgURL\":\""+imgURL+"\"}";
////        return returnjson;
//         model.addAttribute("imgpath", imgURL);
//         return "upload_img";
//
//
//    }
//
//
//    /**
//     * 转到错误页面
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(Exception.class)
//    public String myselfException(Exception e, Model modle) {
//        modle.addAttribute("message", e);
//        e.printStackTrace();
//        return "Erro";
//    }
//
//}
