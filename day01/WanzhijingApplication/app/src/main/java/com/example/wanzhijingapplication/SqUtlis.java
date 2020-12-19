package com.example.wanzhijingapplication;



import com.example.wanzhijingapplication.dpo.DaoMaster;
import com.example.wanzhijingapplication.dpo.DaoSession;
import com.example.wanzhijingapplication.dpo.SqBeanDao;

import java.util.List;

public class SqUtlis {
    private static SqUtlis sqUtlis;
    private final SqBeanDao sqBeanDao;

    public static SqUtlis getSqUtlis() {
        if(sqUtlis==null){
            synchronized (SqUtlis.class){
                if (sqUtlis==null){
                    sqUtlis=new SqUtlis();
                }
            }
        }
        return sqUtlis;
    }

        public SqUtlis() {
            DaoMaster.DevOpenHelper user = new DaoMaster.DevOpenHelper(App.getApp(), "aaaa");
            DaoMaster daoMaster = new DaoMaster(user.getWritableDb());
            DaoSession session = daoMaster.newSession();
            sqBeanDao = session.getSqBeanDao();

        }
        public Long insert(SqBean sqBean){
            long insert = sqBeanDao.insert(sqBean);
            return insert;
        }
        public List<SqBean> select(){
            List<SqBean> list = sqBeanDao.queryBuilder().list();
            return list;
        }
        public void update(SqBean sqBean){
            sqBeanDao.update(sqBean);
        }
        public void delete(SqBean sqBean){
            sqBeanDao.delete(sqBean);
        }
}
