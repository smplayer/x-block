package com.sm.xblock.service.impl;

import com.sm.common.dao.GenericDao;
import com.sm.common.query.hibernate.Conditions;
import com.sm.common.service.impl.GenericServiceImpl;
import com.sm.xblock.dao.KeyDao;
import com.sm.xblock.entity.Key;
import com.sm.xblock.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

/**
 * Created by smplayer on 2016/5/4.
 */
@Service("keyService")
public class KeyServiceImpl extends GenericServiceImpl<Key, String> implements KeyService {

    @Autowired
    private KeyDao keyDao;

    @Override
    protected GenericDao<Key, String> getDao() {
        return keyDao;
    }

    @Override
    public void generate(Integer length) {
        Random rm = new Random();
        try {
            String chars = null;

            for(int r = 0; r < 2; r++){
                char c1 = 'A';
                char c2 = 'A';

                if(r == 0){
                    for(; c1 <= 'Z'; c1++){
                        chars = String.valueOf(c1);

                        FileOutputStream out = new FileOutputStream("O:/keys/keys" + chars +".txt");
                        PrintStream p = new PrintStream(out);

                        toSN(chars, p, rm, length);

                        p.close();
                    }
                } else {
                    for(; c1 <= 'Z'; c1++){
                        for(;c2 <= 'Z'; c2++){
                            chars = String.valueOf(new char[]{c1, c2});

                            FileOutputStream out = new FileOutputStream("O:/keys/keys" + chars +".txt");
                            PrintStream p = new PrintStream(out);

                            toSN(chars, p, rm, length);

                            p.close();
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void toSN(String chars, PrintStream p, Random rm, Integer length){
        for(int i = 0; i < 50000; i++) {

            // 获得随机数
            double pross1 = (1 + rm.nextDouble()) * Math.pow(10, length);
            // 将获得的获得随机数转化为字符串
            String fixLenthString1 = String.valueOf(pross1);

            // 获得随机数
            double pross2 = (1 + rm.nextDouble()) * Math.pow(10, length);
            // 将获得的获得随机数转化为字符串
            String fixLenthString2 = String.valueOf(pross2);

            String s = fixLenthString1.substring(2, length + 1) + chars + fixLenthString2.substring(2, length + 1);

            Key existingKey = get(Conditions.newInstance().eq("content", s));
            if (existingKey == null) {
                Key newKey = new Key();
                newKey.setContent(s);
                save(newKey);
                p.println(s);
                System.out.println(s);
            } else {
                System.out.println("重复");
            }

        }
    }
}
