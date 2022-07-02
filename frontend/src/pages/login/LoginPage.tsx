import styles from "./LoginPage.module.scss"
import ClickableButton from "../../components/buttons/clickable_button/ClickableButton";
import AppCard from "../../components/card/AppCard";

const LoginPage = () => (
    <div className={styles.loginContainer}>
        <AppCard>
            <form>
                <div className={styles.inputWrapper}>
                    <label htmlFor="username">Username</label>
                    <input type="text" id="username" name="username"/>
                </div>
                <div className={styles.inputWrapper}>
                    <label htmlFor="password">Password</label>
                    <input type="password" id="password" name="password"/>
                </div>
                <div className="d-flex justify-content-center mt-3">
                    <ClickableButton buttonName={"Login!"}/>
                </div>
            </form>
        </AppCard>
    </div>
)

export default LoginPage
