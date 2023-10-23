import { useContext, useState } from "react";
import { Alert, Button, Form } from "react-bootstrap";
import cookie from "react-cookies";
import { Navigate, useSearchParams } from "react-router-dom";
import { MyUserContext } from "../App";
import Apis, { authApi, endpoint } from "../configs/Apis";

const Login = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    const [q] = useSearchParams();
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
   

    const login = (evt) => {
        evt.preventDefault();

        if (!username || !password) {
            setErr("Vui lòng nhập tên đăng nhập và mật khẩu.");
            return;
        }
        const process = async () => {
            setLoading(true);
            try {
            let res = await Apis.post(endpoint['login'],{
                "username": username,
                "password": password
            });
            //console.info(res.data);
            cookie.save("token", res.data);

            let {data} = await authApi().get(endpoint['current-user']);
            cookie.save("user", data)

            dispatch({
                "type": "login",
                "payload": data
            });
        } catch(err) {
            setErr("Tên đăng nhập hoặc mật khẩu không đúng. Vui lòng thử lại.");
            setLoading(false);
        }
           
        }

        process();
    }

   

    if (user !== null) {
        let next = q.get("next") || "/";
        return <Navigate to={next} />
    }

    return (
        <>
        <h2 className="text-center mt-5">ĐĂNG NHẬP</h2>
        {err && <Alert variant="danger">{err}</Alert>}
        <Form onSubmit={login}>
            <Form.Group className="mb-3" >
                <Form.Control  value={username} onChange={e => setUsername(e.target.value)} type="text" placeholder="Tên đăng nhập" />
            </Form.Group>
            <Form.Group className="mb-3" >
                <Form.Control value={password} onChange={e => setPassword(e.target.value)} type="password" placeholder="Mật khẩu" />
            </Form.Group>
            <Form.Group className="mb-3 text-center" controlId="exampleForm.ControlInput1">
                <Button   variant="primary" type="submit">{loading === true ? 'Đang tải…' : 'Đăng nhập'}</Button>
            </Form.Group>
        </Form>
        </>
    )
}

export default Login;