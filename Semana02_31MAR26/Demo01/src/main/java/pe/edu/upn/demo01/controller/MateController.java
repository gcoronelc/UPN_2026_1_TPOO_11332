package pe.edu.upn.demo01.controller;

import pe.edu.upn.demo01.service.MateService;

public class MateController {

    private MateService mateService;

    public MateController() {
        mateService = new MateService();
    }

    public int sumar(int num1, int num2) {
        return mateService.sumar(num1, num2);
    }

    public int restar(int num1, int num2) {
        return mateService.restar(num1, num2);
    }

}
