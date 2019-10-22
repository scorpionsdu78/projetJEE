<%-- 
    Document   : template_sticky_top
    Created on : 22 oct. 2019, 14:30:35
    Author     : Eddy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="">Employees Management</a>
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item" style="width: 10vh">
            </li>
            <li class="nav-item active">
                <span class="navbar-text">
                  Hello 'user' ! Your session is active
                </span>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="btn btn-light" href="goodbye.jsp" style="color: black; font-size: 8px; font-size: 1.2vw;">
                    Log out
                    <span style="
    background-image: url('https://c7.uihere.com/icons/826/332/883/operating-log-off-860f8851a94474056cfa47ff8435ddc1.png');
    background-size: cover;
    background-repeat: no-repeat;
    background-position: 50% 50%;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                </a>
            </li>
        </ul>
    </div>
</nav>