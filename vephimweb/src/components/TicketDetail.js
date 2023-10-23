import { useEffect, useState } from "react";
import { Button, Form } from "react-bootstrap";
import { useParams } from "react-router-dom";
import Apis, { authApi, endpoint } from "../configs/Apis";
import MySpinner from "../layout/MySpinner";

const TicketDetail = () => {

    const {veID} = useParams();
    const [ticket, setTicket] = useState(null);
    const [noiDung, setNoiDung] = useState();

    useEffect(() => {

        const loadTicket = async () => {
            try {
                let {data} =  await Apis.get(endpoint['ticket_detail'](veID));               
                setTicket(data);
            } catch (ex) {
                console.error(ex);
            }
        }
        loadTicket();
    }, [])

    const addFeedback = () => {
        const process = async () => {
            let {data} = await authApi().post(endpoint['add_feedbacks'], {
                "noiDung": noiDung,
                "veID": ticket.veID
            });
        }

        process();
    }


    
    if(ticket === null) {
        return <MySpinner />
    }

    return (
        <>
            <h1>Ticket detail</h1>
            <Form.Control as="textarea" aria-label="With textarea" value={noiDung} onChange={e => setNoiDung(e.target.value)} placeholder="Nhập nội dung phản hồi" />
            <Button onClick={addFeedback} className="mt-2" variant="info">Phản hồi</Button>
        </>
    )
}

export default TicketDetail;