import java.util.FormatFlagsConversionMismatchException;

public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
    public double G=6.67e-11;

    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
               xxPos = xP;
               yyPos = yP;
               xxVel = xV;
               yyVel = yV;
               mass = m;
               imgFileName = img;
              }
    
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
        
    }

    public double calcDistance(Planet other){
        double xxdif;
        double yydif;
        double r;
        xxdif= xxPos- other.xxPos;
        yydif= yyPos- other.yyPos;
        r = Math.sqrt(Math.pow(xxdif,2)+ Math.pow(yydif,2));
        return r;

    }

    public double calcForceExertedBy(Planet other){
        double F;
        double r =this.calcDistance(other);
        F= G* mass * other.mass / Math.pow(r,2);
        return F;     

    }

    public double calcForceExertedByX (Planet other){
            double F=calcForceExertedBy(other);
        double r=this.calcDistance(other);
        double dx=other.xxPos- xxPos;
        double Fx=F* dx /r;
        return Fx;
    }

    public double calcForceExertedByY(Planet other){
        double F=calcForceExertedBy(other);
        double r=calcDistance(other);
        double dy=other.yyPos- yyPos;
        double Fy=F*dy/r;
        return Fy;
    
    }

    public double calcNetForceExertedByX(Planet[] other){
        double TotalForce= 0;
        for (Planet A : other){
            if (this.equals(A))
                continue;
                TotalForce += calcForceExertedByX(A);
            
        }
        return TotalForce;

    }

    public double calcNetForceExertedByY(Planet[] other){
        double TotalForce= 0;
        for (Planet A : other){
            if (this.equals(A))
                continue;
                TotalForce += calcForceExertedByY(A);
            
        }
        return TotalForce;
    }

    public void update(double dt, double fx, double fy){
        double a_x= fx/ mass;
        double a_y= fy/ mass;
        /* 更新速度 */
        xxVel= xxVel+ dt * a_x;
        yyVel= yyVel+ dt * a_y;
        /*更新坐标*/
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;

    }
    public void Draw(){
        
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

    
}



      
