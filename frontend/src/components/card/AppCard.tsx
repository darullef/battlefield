import styles from './AppCard.module.scss'

const AppCard = ({children}: { children: any }) => (
    <div className={styles.card}>
        {children}
    </div>
)

export default AppCard
