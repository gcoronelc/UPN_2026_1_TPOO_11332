package pe.edu.upn.semana11.impl;

import pe.edu.upn.semana11.spec.MateSpec;

public class MateImpl implements MateSpec{

    @Override
    public long factorial(int n) {
        if(n==0 || n==1) return 1;
        return n * factorial(n-1);
    }
    
}
