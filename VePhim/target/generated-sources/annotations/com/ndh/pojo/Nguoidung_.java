package com.ndh.pojo;

import com.ndh.pojo.Vaitro;
import com.ndh.pojo.Ve;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-23T18:51:32")
@StaticMetamodel(Nguoidung.class)
public class Nguoidung_ { 

    public static volatile SingularAttribute<Nguoidung, String> hinhDaiDien;
    public static volatile SingularAttribute<Nguoidung, String> password;
    public static volatile SingularAttribute<Nguoidung, String> ho;
    public static volatile SingularAttribute<Nguoidung, Vaitro> vaiTroID;
    public static volatile SingularAttribute<Nguoidung, String> ten;
    public static volatile SetAttribute<Nguoidung, Ve> veSet;
    public static volatile SingularAttribute<Nguoidung, Integer> nguoiDungID;
    public static volatile SingularAttribute<Nguoidung, String> username;

}