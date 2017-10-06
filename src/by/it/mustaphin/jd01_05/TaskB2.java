/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.it.mustaphin.jd01_05;

/**
 *
 * @author marat
 */
public class TaskB2 {

    double r = 0.491 * Math.pow(10, 4);
    double p = 0;
    double z = 0;
    double y = 0;

    //По какой-то причине при "p" равном 10, шаг увеличивается до 2.0 и так значение "p" до 15 включительно(!!!)
    void calcY() {
	for (double p = -0.5; p < 15; p += 1.5) {
	    if (p - 1 < 0) {
		z = 3.8 * Math.sin(p);
		y = Math.pow(4.67, Math.abs(z - 1.4 * r));
		System.out.printf("При p=%-1.2g y=%-7.8g\n", p, z);
	    } else if (0 <= (p - 1) || (p - 1) < 3) {
		z = Math.pow(p, 3) - p;
		y = Math.pow(4.67, Math.abs(z - 1.4 * r));
		System.out.printf("При p=%-1.2g y=%-7.8g\n", p, z);
	    } else if (p - 1 >= 3) {
		z = Math.pow((2 / (p + 1)) + (Math.sin(Math.PI / 6)), 5);
		y = Math.pow(4.67, Math.abs(z - 1.4 * r));
		System.out.printf("При p=%-1.2g y=%-7.8g\n", p, z);
	    }
	}
    }
}
