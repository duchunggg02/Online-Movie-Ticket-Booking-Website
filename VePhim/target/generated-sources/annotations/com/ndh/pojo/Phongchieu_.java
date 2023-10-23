package com.ndh.pojo;

import com.ndh.pojo.Chongoi;
import com.ndh.pojo.Rapphim;
import com.ndh.pojo.Suatchieu;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-23T18:51:32")
@StaticMetamodel(Phongchieu.class)
public class Phongchieu_ { 

    public static volatile SetAttribute<Phongchieu, Chongoi> chongoiSet;
    public static volatile SingularAttribute<Phongchieu, Integer> phongChieuID;
    public static volatile SingularAttribute<Phongchieu, Integer> soLuongGhe;
    public static volatile ListAttribute<Phongchieu, Chongoi> chongoiList;
    public static volatile SingularAttribute<Phongchieu, Rapphim> rapPhimID;
    public static volatile SetAttribute<Phongchieu, Suatchieu> suatchieuSet;
    public static volatile SingularAttribute<Phongchieu, String> tenPhongChieu;

}