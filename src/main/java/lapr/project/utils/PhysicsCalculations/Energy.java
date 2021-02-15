package lapr.project.utils.PhysicsCalculations;

/**
 * The type Energy.
 */
public abstract class Energy {

    /**
     * Energy between two points scooter double.
     *
     * @return the double
     */
    public static double energyBetweenTwoPointsScooter(){
        return -1;
        /*
        double v_media_veiculo = 20;
        double dens_ar = 1.5;
        double a_grav = 10;
        double coeficiente_de_atrito = 4;

        double v_vento_rel_ = windSpeed * Math.cos(45);

        double v_rel_x = v_media_veiculo - v_vento_rel_;

        double arrastro_ar = 0.5 * dens_ar * coef_veiculo_ * area_frontal_veiculo * Math.pow(v_rel_x,2);

        double atrito_solo = a_grav * veic_wieght * coeficiente_de_atrito;

        double energi = (arrastro_ar * atrito_solo ) / distancia / 3600;

         */
    }

    /**
     * Energy between two points drone double.
     *
     * @return the double
     */
    public static double energyBetweenTwoPointsDrone(){ return -1; }
}
