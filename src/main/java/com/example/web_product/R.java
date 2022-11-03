package com.example.web_product;

import java.util.HashMap;

public class R extends HashMap<String,Object> {
    private static final long serialVersionUID=1L;
    private R(){//操作成功对象
        put("code",201);
        put("message","操作成功");
        put("success",true);
    }
    public static R ok(){//返还成功对象
        return new R();
    }
    public static R err(){//返还失败对象
       R r=new R();
       r.put("code",501);
       r.put("message","操作失败");
       r.put("success",false);
       return r;
    }

    public R put(String key,Object value){
        super.put(key,value);
        return this;
    }
}
