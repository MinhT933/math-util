/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinhT.dto;

/**
 *
 * @author Lucires
 */
public class UserError {
    private String userIDError;
    private String fullNameError;
    private String passwordError;
    private String confirmError;

    public UserError(String userIDError, String fullNameError, String passwordError, String confirmError) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    @Override
    public String toString() {
        return "UserError{" + "userIDError=" + userIDError + ", fullNameError=" + fullNameError + ", passwordError=" + passwordError + ", confirmError=" + confirmError + '}';
    }

   
    
}
