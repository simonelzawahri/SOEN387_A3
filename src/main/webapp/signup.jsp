
<jsp:include page="header.jsp"/>

<div class="mainSignup">
    <h1>Signup</h1>

    <form method="POST" action="<%= request.getContextPath() %>/signup" id="SignUpForm">
        Select one:
        <br>
        <input type="radio" name="iam" id="iamStudent" value="0" required>
        <label for="iamStudent" id="iamStudentLabel">i am student</label>
        <br>
        <input type="radio" name="iam" id="iamAdmin" value="1" required>
        <label for="iamAdmin" id="iamAdminLabel">i am admin</label>
        <br>

        <br>
        <label for="id" id="IDlabel">Enter ID:</label>
        <input type="text" name="id" id="id" required>
        <p id="iderror" style="color: red; font-weight: 500; display: none;">ID must contain only numbers.</p>
        <br>

        <br>
        <label for="fname">First Name:</label>
        <input type="text" name="fname" id="fname" required>
        <p id="fnameerror" style="color: red; font-weight: 500; display: none;">First Name must contain only letters (for "-" use space).</p>
        <br>

        <br>
        <label for="lname">Last Name:</label>
        <input type="text" name="lname" id="lname" required>
        <p id="lnameerror" style="color: red; font-weight: 500; display: none;">Last Name must contain only letters (for "-" use space).</p>
        <br>

        <br>
        <label for="address">Address:</label>
        <input type="text" name="address" id="address" required>
        <p id="addresserror" style="color: red; font-weight: 500; display: none;">Address must be minimum 3 characters. <br>
            Characters may include a-z, A-Z alphabets, <br>
            whitespace, comma(,), dot(.), apostrophe (') <br>
            or dash(-) symbols.</p>
        <br>

        <br>
        <label for="email">Email:</label>
        <input type="email" name="email" id="email" required>
        <br>

        <br>
        <label for="phone">Phone Number:</label>
        <input type="text" name="phone" id="phone" required>
        <p id="phoneerror" style="color: red; font-weight: 500; display: none;">Phone Number must contain only numbers with the following formats: <br>
            ###-###-#### <br>
            (###) ###-#### <br>
            ### ### ####  <br>
            ###.###.#### <br>
            ########## </p>
        <br>

        <br>
        <label for="dob">DOB:</label>
        <input type="date" name="dob" id="dob" required>
        <br>

        <br>
        <label for="pass">Password:</label>
        <input type="password" name="pass" id="pass" required>
        <br>

        <br>
        <input type="submit" name="submit" value="Signup" id="button">

    </form>
</div>



<script>
    // Dynamic ID label
    const iamStudent = document.querySelector(".mainSignup #SignUpForm #iamStudent");
    const iamAdmin = document.querySelector(".mainSignup #SignUpForm #iamAdmin");
    var IDlabel = document.querySelector(".mainSignup #SignUpForm #IDlabel");
    iamStudent.addEventListener('input', function(e){
        if(iamStudent){
            IDlabel.innerHTML = "Student ID:"
        }
    });
    iamAdmin.addEventListener('input', function(e){
        if(iamAdmin){
            IDlabel.innerHTML = "Admin ID:"
        }
    });

    // validate ID
    const id = document.querySelector(".mainSignup #SignUpForm #id");
    const iderror = document.querySelector(".mainSignup #SignUpForm #iderror");
    id.addEventListener('input', function(e){
        var IDpattern = /^\d+$/;
        var IDvalue = e.target.value;
        var IDvalid = IDpattern.test(IDvalue);
        if(IDvalid){
            iderror.style.display = "none";
        } else {
            iderror.style.display = "block"
        }
    });

    // validate first name
    const fname = document.querySelector(".mainSignup #SignUpForm #fname");
    const fnameerror = document.querySelector(".mainSignup #SignUpForm #fnameerror");
    fname.addEventListener('input', function(e){
        var fnamePattern = /^[A-Za-z\s]*$/;
        var fnameValue = e.target.value;
        var fnameValid = fnamePattern.test(fnameValue);
        if(fnameValid){
            fnameerror.style.display = "none";
        } else {
            fnameerror.style.display = "block"
        }
    });

    // validate last name
    const lname = document.querySelector(".mainSignup #SignUpForm #lname");
    const lnameerror = document.querySelector(".mainSignup #SignUpForm #lnameerror");
    lname.addEventListener('input', function(e){
        var lnamePattern = /^[A-Za-z\s]*$/;
        var lnameValue = e.target.value;
        var lnameValid = lnamePattern.test(lnameValue);
        if(lnameValid){
            lnameerror.style.display = "none";
        } else {
            lnameerror.style.display = "block"
        }
    });

    // validate address
    const address = document.querySelector(".mainSignup #SignUpForm #address");
    const addresserror = document.querySelector(".mainSignup #SignUpForm #addresserror");
    address.addEventListener('input', function(e){
        var addressPattern =  /^[a-zA-Z0-9\s,.'-]{3,}$/;
        var addressValue = e.target.value;
        var addressValid = addressPattern.test(addressValue);
        if(addressValid){
            addresserror.style.display = "none";
        } else {
            addresserror.style.display = "block"
        }
    });

    // validate phone
    const phone = document.querySelector(".mainSignup #SignUpForm #phone");
    const phoneerror = document.querySelector(".mainSignup #SignUpForm #phoneerror");
    phone.addEventListener('input', function(e){
        var phonePattern = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]?\d{3}[\s.-]?\d{4}$/;
        var phoneValue = e.target.value;
        var phoneValid = phonePattern.test(phoneValue);
        if(phoneValid){
            phoneerror.style.display = "none";
        } else {
            phoneerror.style.display = "block"
        }
    });
</script>


</body>
</html>
