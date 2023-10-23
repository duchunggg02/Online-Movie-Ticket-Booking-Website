import { useEffect, useRef, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Apis, { endpoint } from "../configs/Apis";

const Register = () => {

    const [user, setUser] = useState({
            "username": "", 
            "password": "", 
            "ho": "", 
            "ten": "", 
            "confirmPassword": ""});
    const avatar = useRef();
    const nav = useNavigate();
    const [loading, setLoading] = useState(false);
    const [err, setErr] = useState(null);
    const [usernameExists, setUsernameExists] = useState(false);

    useEffect(() => {
        const checkUsernameExists = async () => {
            try {
                if (user.username) {
                let res = await Apis.get(endpoint['isExistUsername'], {
                    params: {
                        username: user.username
                    }
                });
    
                console.log(res)
                if(res.data !== "SUCCESSFUL") {
                    setUsernameExists(true);
                   
                } else  {
                    setUsernameExists(false);
                }
            } 
            } catch (err) {
                console.error(err);
            }
        }
        checkUsernameExists();
    },[user.username]);
   

    const register = (evt) => {
        evt.preventDefault();

        console.log("usernameExists:", usernameExists);
        if (usernameExists === true) {
            setErr("Tên đăng nhập đã tồn tại. Vui lòng chọn tên đăng nhập khác.");
            return;
        }

        for (let field in user) {
            if (!user[field]) {
                setErr("Vui lòng điền đầy đủ thông tin.");
                return;
            }
        }
        if (!avatar.current.files[0]) {
            setErr("Vui lòng chọn ảnh đại diện.");
            return;
        }

      
        if (user.password !== user.confirmPassword) {
            setErr("Mật khẩu và xác nhận mật khẩu không khớp.");
            return;
        }

      

        const process = async () => {


           
            let form = new FormData();

            //form.append("username", user.username)
            for(let field in user) 
                if(field !== "confirmPassword")
                    form.append(field, user[field]); 

            form.append("avatar", avatar.current.files[0]);

            setLoading(true);
            let res = await Apis.post(endpoint['register'], form)
            if(res.status === 201) {
                nav("/login")
                setLoading(false);
            } else {
                setErr("Đã có lỗi xảy ra. Vui lòng thử lại.");
            }
        }

      
           process();
     

        
    }

    const change = (evt, field) => {
        //setUser({...user, [field]: evt.target.value})
        setUser(current => { 
            return {...current, [field]: evt.target.value}
        })
    }

    return (
        <>
            <h2 className="text-center mt-5">ĐĂNG KÝ</h2>
            {err && <Alert variant="danger">{err}</Alert>}
            <Form onSubmit={register}>
                <Form.Group className="mb-3" >
                  
                    <Form.Control value={user.username} onChange={(e) => change(e, "username")} type="text" placeholder="Tên đăng nhập"/>
                </Form.Group>
                <Form.Group className="mb-3" >
                   
                    <Form.Control value={user.password} onChange={(e) => change(e, "password")} type="password" placeholder="Mật khẩu" />
                </Form.Group>
                <Form.Group className="mb-3" >
                  
                    <Form.Control value={user.confirmPassword} onChange={(e) => change(e, "confirmPassword")} type="password" placeholder="Nhập lại mật khẩu"/>
                </Form.Group>
                <Form.Group className="mb-3" >
                  
                    <Form.Control value={user.ho} onChange={(e) => change(e, "ho")} type="text" placeholder="Họ và chữ lót" />
                </Form.Group>
                <Form.Group className="mb-3" >
                 
                    <Form.Control value={user.ten} onChange={(e) => change(e, "ten")} type="text" placeholder="Tên" />
                </Form.Group>
                <Form.Group className="mb-3" >
                   
                    <Form.Control  type="file" ref={avatar} />
                </Form.Group>
                <Form.Group className="mb-3 text-center">
                 <Button variant="success"  type="submit"> {loading === true ? 'Đang tải…' : 'Đăng ký'}</Button>              
                </Form.Group>
            </Form>
        </>
    )
}

export default Register;