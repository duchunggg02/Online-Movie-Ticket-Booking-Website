package com.ndh.pojo;

import com.ndh.pojo.Phongchieu;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-23T18:51:32")
@StaticMetamodel(Rapphim.class)
public class Rapphim_ { 

    public static volatile SingularAttribute<Rapphim, String> diaChi;
    public static volatile SingularAttribute<Rapphim, String> anhRap;
    public static volatile SetAttribute<Rapphim, Phongchieu> phongchieuSet;
    public static volatile SingularAttribute<Rapphim, Integer> rapPhimID;
    public static volatile SingularAttribute<Rapphim, String> tenRapPhim;

}