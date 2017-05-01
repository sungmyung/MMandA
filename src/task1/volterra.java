package task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class volterra {

	public static void main(String[] args) {
		double u, v, w, x;
		double t,T=30;
		double u0=0.5, v0=0.5;
		double h=0.001; //ここのパラメータを調整

		u = u0;
		v = v0;

		try {
			FileWriter fw = new FileWriter("volterra.csv",false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			for(t=0; t<=T; t=t+h) {
				pw.println(u+","+v);

				//wはu(n)，xはv(n)
				w = u;
				x = v;

				//1-2ではここの式を修正
				u = w + h * ( w - 2*w*x );
				v = x + h * ( w*x - x );
			}
			pw.close();
		} catch (IOException e) {
			System.out.println("File write error:" + e);
		}
	}
}
