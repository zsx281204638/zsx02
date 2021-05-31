package com.itheima.controller;

import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.Setmeal;
import com.itheima.service.SetmealService;
import com.itheima.utils.QiNiuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/setmeal")
public class SetmealController {
    @Autowired
    private SetmealService setmealService;
     @PostMapping("/upload")
         public Result upload(MultipartFile imgFile){
         //- MultipartFile imgFile 接收上传过来的图片
         //- 获取原文件名，
         String originalFilename = imgFile.getOriginalFilename();
         // 截取后缀
         String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
         //- 生成唯一文件名，拼接后缀
         String filename = UUID.randomUUID().toString() + suffix;
         //- 调用QiNiuUtils上传
         try {
             QiNiuUtils.uploadViaByte(imgFile.getBytes(),filename);
             //- 返回结果给前端：
             /**
              * result{
              *     flag:
              *     message:
              *     data:{
              *     	  imgName: 唯一的文件名(七牛上的文件名) 补充formData.img
              * 		  domain: 七牛上bucket的域名  imageUrl=domain+imgName
              *     }
              * }
              */
             //构造 返回的数据
             Map<String,String> resultMap = new HashMap<String,String>();
             resultMap.put("imgName",filename);
             resultMap.put("domain",QiNiuUtils.DOMAIN);
             return new Result(true, MessageConstant.PIC_UPLOAD_SUCCESS,resultMap);
         } catch (IOException e) {
             e.printStackTrace();
             return new Result(false, MessageConstant.PIC_UPLOAD_FAIL);
         }
     }
     @PostMapping("/add")
         public Result add(@RequestBody Setmeal setmeal, Integer[] checkgroupIds){
            setmealService.add(setmeal,checkgroupIds);
            return  new Result(true,MessageConstant.ADD_SETMEAL_SUCCESS);

         }
}
