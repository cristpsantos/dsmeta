import axios from "axios";
import Icon from "../../assets/imgs/Notification.svg";
import { BASE_URL } from "../../util/requests";

import "./styles.css";

type Props = {
  saleId: number;
};

function handleClick(id: number) {
  axios.get(`${BASE_URL}/sales/${id}/notification`).then(() => {
    console.log("Enviada com sucesso!");
  });
}

function NotificationIcon({ saleId }: Props) {
  return (
    <div className="dsmeta-red-btn" onClick={() => handleClick(saleId)}>
      <img src={Icon} alt="Notificar" />
    </div>
  );
}

export default NotificationIcon;
