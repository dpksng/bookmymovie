
$(function() {

  $("form[name='registration']").validate({
    
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      email: "required",
      name: "required",
      dob: "required",
      gender: "required",
      answer1: "required",
      answer2: "required",
      pwd: "required",
      conf: "required",
      
      email: {
        required: true,
        email: true
      },
      pwd: {
        required: true,
        minlength: 6,
        maxlength: 12
      },
      conf: {
          required: true,
          minlength: 6,
          maxlength: 12
        }
    },
    // Specify validation error messages
    messages: {
      name: "Please enter your name",
      dob:"Please enter your date of birth",
      gender:"Please enter your gender",
      answer1:"Please enter your security question answer",
      answer2:"Please enter your security question answer",
      pwd: {
        required: "Please provide a password",
        minlength: "Your password must be at least 6 characters long",
        maxlength: "Your password must be maximum 12 characters long"
      },
      conf: {
          required: "Please provide a password",
          minlength: "Your password must be at least 6 characters long",
          maxlength: "Your password must be maximum 12 characters long"
        },
      email: "Please enter a valid email address"
    },
    
    submitHandler: function(form) {
      form.submit();
    }
  });
});