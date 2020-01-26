/**
<<<<<<< HEAD
 * Created by HXW on 2019/7/2.
=======
 * Created by xtnloveyou on 2019/7/2.
>>>>>>> origin/master
 */
jQuery(function () {
    jQuery("#zc").click(function () {
        var userName = jQuery("#username").val();
        var Email = jQuery("#email").val();
        var Phone = jQuery("#phone").val();
        var Password = jQuery("#password").val();
        var Password1 = jQuery("#password1").val();
        var Checked = jQuery("#checked").val();
        if (userName == null || !userName.eq("")) {
            alert("用户名不能为空");
            location.replace(location.href);
        } else if (Email != null) {
            alert("邮箱不能为空");
            location.replace(location.href);
        } else if (Phone != null || Phone.length != 11) {
            alert("电话号码有误请仔细查看");
            location.replace(location.href);
        } else if (Password != null || !Password.eq("")) {
            alert("密码不能为空");
            location.replace(location.href);
        } else if (Password != Password1) {
            alert("两次密码不唯一");
            location.replace(location.href);
        }
    });
})
