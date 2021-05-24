package com.example.wsn.bbsadminsys.controller;
/*
 *project:JavaCode
 *file:Classify
 *@author:wsn
 *date:2021/5/19 8:23
 */

import com.example.wsn.bbsadminsys.dao.ArticleDao;
import com.example.wsn.bbsadminsys.dao.TypesDao;
import com.example.wsn.bbsadminsys.domain.ArtTypeDao;
import com.example.wsn.bbsadminsys.domain.TypeNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/classify")
public class Classify {

    @Autowired
    TypesDao typesDao;
    @Autowired
    ArticleDao articleDao;

    @RequestMapping("/typename")
    public Map<String, List<TypeNames>> getTypeName(){
        Map<String, List<TypeNames>> data=new HashMap<>();
        List<String> f_names=new ArrayList<>();
        List<TypeNames> allType = typesDao.getAllType();
        for(TypeNames tn:allType){
            if(!f_names.contains(tn.getFather_name())){
                f_names.add(tn.getFather_name());
            }
        }
        for(String s:f_names){
            List<TypeNames> child=new ArrayList<>();
            for(TypeNames tn:allType){
                if(s.equals(tn.getFather_name())){
                    child.add(tn);
                }
            }
            data.put(s,child);
        }
        return data;
    }

    @RequestMapping("/changefname")
    public boolean changeFatherName(String oldname,String newname){
        return typesDao.changeFname(oldname,newname);
    }
    @RequestMapping("/changecname")
    @Transactional
    public String changeChildName(int t_id,String newname){

        typesDao.changeCname(t_id,newname);
        return typesDao.getFname(t_id);
    }

    @RequestMapping("/delcname")
    @Transactional
    public String delChildName(int t_id){
        String name="";
        List<ArtTypeDao> typeArt = typesDao.getTypeArt(t_id);
        if(typeArt!=null) {
            for (ArtTypeDao at : typeArt) {
                articleDao.deleteCollect(at.getArt_id());
                articleDao.deleteArtComm(at.getArt_id());
                articleDao.deleteArt(at.getArt_id());
            }
        }
        name=typesDao.getFname(t_id);
        typesDao.delChildType(t_id);
        return name;
    }
    @RequestMapping("/delfname")
    @Transactional
    public boolean delFatherName(String fname){
        List<TypeNames> faCh = typesDao.getFaCh(fname);
        for(TypeNames tn:faCh){
            delChildName(tn.getT_id());
        }
        return true;
    }

    @RequestMapping("/addtype")
    public String addNewType(String childname,String fathername){
        typesDao.addNewType(childname,fathername);
        return fathername;
    }

    @RequestMapping("/upimg/{id}")
    @Transactional
    public Map<String,String> uploadImg( MultipartFile file, @PathVariable String id){
        Map<String,String> res=new HashMap<>();

        if(!file.isEmpty()){
            String originalFilename = file.getOriginalFilename();
            String[] split = originalFilename.split("\\.");
            String filename="back"+id+"."+split[1];
            File f=new File("E:\\img\\"+filename);
            if(f.exists()) {
                boolean delete = f.delete();
            }
            try {
                file.transferTo(f);
                typesDao.updateImgName(Integer.parseInt(id),filename);
                res.put("code","0");
            } catch (IOException e) {
                e.printStackTrace();
                res.put("code","1");
            }
        }
        else {
            res.put("code","1");

        }
        return res;
    }

}
