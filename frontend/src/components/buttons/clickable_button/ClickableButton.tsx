import styles from './ClickableButton.module.scss'
import React, {FC} from "react";

interface ClickableButtonProps {
    buttonName: string;
}

const ClickableButton: FC<ClickableButtonProps> = ({buttonName}) => (
    <button className={styles.button}>
        {buttonName}
    </button>
)

export default ClickableButton;
