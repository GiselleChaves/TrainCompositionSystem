public class Vagao {
  private int idVagao;
  private int capacidadeMaximaDeCarga;
  private int pesoDoVagao;
  //TREM[]

  /**
   * @param idVagao
   * @param capacidadeMaximaDeCarga
   * @param pesoDoVagao
   */
  public Vagao(int idVagao, int capacidadeMaximaDeCarga, int pesoDoVagao) {
    this.idVagao = idVagao;
    this.capacidadeMaximaDeCarga = capacidadeMaximaDeCarga;
    this.pesoDoVagao = pesoDoVagao;
  }

  public int getIdVagao() {
    return idVagao;
  }

  public int getCapacidadeMaximaDeCarga() {
    return capacidadeMaximaDeCarga;
  }

  public int getPesoDoVagao() {
    return pesoDoVagao;
  }

  public void setIdVagao(int idVagao) {
    this.idVagao = idVagao;
  }

  public void setCapacidadeMaximaDeCarga(int capacidadeMaximaDeCarga) {
    this.capacidadeMaximaDeCarga = capacidadeMaximaDeCarga;
  }

  public void setPesoDoVagao(int pesoDoVagao) {
    this.pesoDoVagao = pesoDoVagao;
  }

}
