package lapr.project.controller;

import lapr.project.model.Pharmacy;
import lapr.project.model.PharmacyService;
import lapr.project.model.Product;
import lapr.project.utils.PhysicsCalculations.Distance;

import java.util.List;

/**
 * The type Get nearest pharmacy controller.
 */
public class getNearestPharmacyController {

    private final PharmacyService pServ = new PharmacyService();


    /**
     * Instantiates a new Get nearest pharmacy controller.
     */
    public getNearestPharmacyController() {
    }


    /**
     * Gets nearest pharmacy with product.
     *
     * @param pSrc  the p src
     * @param prod  the prod
     * @param stock the stock
     * @return the nearest pharmacy with product
     */
    public Pharmacy getNearestPharmacyWithProduct(Pharmacy pSrc, Product prod, long stock) {

        List<Pharmacy> pList = pServ.getAllPharmaciesWithProduct(pSrc, prod, stock);


        return getNearest(pList, pSrc);
    }


    private Pharmacy getNearest(List<Pharmacy> list, Pharmacy pSrc) {

        Pharmacy nearest = null;

        double dist = Double.MAX_VALUE;

        double aux= 0;

        for (Pharmacy p : list) {
            aux = Distance.calculateDistanceBetweenTwoAddresses(p.getAddress(),pSrc.getAddress());

            if(aux<dist){

                dist = aux;
                nearest = p;
            }

        }
        return nearest;
    }


}
