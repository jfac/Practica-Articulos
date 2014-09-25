package bean;

public class BeanVenta 
{
	private int idVta,idArticulos, cantidad;
	private Double monto;
	
	public int getIdVta() {
		return idVta;
	}
	public void setIdVta(int idVta) {
		this.idVta = idVta;
	}
	public int getIdArticulos() {
		return idArticulos;
	}
	public void setIdArticulos(int idArticulos) {
		this.idArticulos = idArticulos;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
