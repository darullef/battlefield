import styles from "../register/RegisterPage.module.scss";
import AppCard from "../../components/card/AppCard";
import ClickableButton from "../../components/buttons/clickable_button/ClickableButton";

const RegisterPage = () => (
    <div className={styles.registerContainer}>
        <AppCard>
            <form>
                <div className={styles.inputWrapper}>
                    <label htmlFor="username">Username</label>
                    <input type="text" id="username" name="username"/>
                </div>
                <div className={styles.inputWrapper}>
                    <label htmlFor="email">Email</label>
                    <input type="email" id="email" name="email"/>
                </div>
                <div className={styles.inputWrapper}>
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" name="password"/>
                </div>
                <div className={styles.inputWrapper}>
                    <label htmlFor="confirmPassword">Confirm password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword"/>
                </div>
                <div className="d-flex justify-content-center mt-3">
                    <ClickableButton buttonName={"Register!"}/>
                </div>
            </form>
        </AppCard>
    </div>
)

export default RegisterPage
