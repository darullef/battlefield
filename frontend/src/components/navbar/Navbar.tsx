const Navbar = () => (
    <nav className="navbar navbar-expand-md navbar-light bg-light">
        <a href="#" className="navbar-brand">Home page</a>
        <button className="navbar-toggler" data-toggle="collapse" data-target="#navbarLinks">
            <span className="navbar-toggler-icon"/>
        </button>
        <div id="navbarLinks" className="collapse navbar-collapse">
            <ul className="navbar-nav">
                <li className="nav-item">
                    <a href="#" className="nav-link">Login</a>
                </li>
                <li className="nav-item">
                    <a href="#" className="nav-link">Register</a>
                </li>
            </ul>
        </div>
    </nav>
)

export default Navbar;