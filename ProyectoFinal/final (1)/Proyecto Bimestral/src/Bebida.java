public class Bebida extends Producto {
    private String tamano;
    private String tipoLeche;

    public Bebida(String id, String nombre, double precioBase, String tamano, String tipoLeche) {
        super(id, nombre, precioBase);
        this.tamano = tamano;
        this.tipoLeche = tipoLeche;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getTipoLeche() {
        return tipoLeche;
    }

    public void setTipoLeche(String tipoLeche) {
        this.tipoLeche = tipoLeche;
    }

    @Override
    public double calcularPrecioFinal() {
        double precio = getPrecioBase();

        if ("mediano".equalsIgnoreCase(tamano)) {
            precio += 0.50;
        } else if ("grande".equalsIgnoreCase(tamano)) {
            precio += 1.00;
        }

        if ("almendra".equalsIgnoreCase(tipoLeche) || "deslactosada".equalsIgnoreCase(tipoLeche)) {
            precio += 0.75;
        }

        return precio;
    }
}
