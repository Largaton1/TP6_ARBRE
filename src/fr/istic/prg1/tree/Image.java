package fr.istic.prg1.tree;

import java.util.Scanner;

import fr.istic.prg1.tree_util.AbstractImage;
import fr.istic.prg1.tree_util.Iterator;
import fr.istic.prg1.tree_util.Node;
import fr.istic.prg1.tree_util.NodeType;

/**
 * @author Bouchra Salma <salma.bouchra@etudiant.univ-rennes1.fr>
 * @author Cyril KONE<largaton-ange-cyril.kone@etudiant.univ-rennes1.fr>
 * @version 5.0
 * @since 2023-10-25
 */

public class Image extends AbstractImage {
	private static final Scanner standardInput = new Scanner(System.in);

	public Image() {
		super();
	}

	public static void closeAll() {
		standardInput.close();
	}

	/**
	 * this devient identique à image2.
	 *
	 * @param image2 image à copier
	 *
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void affect(AbstractImage image2) {
		Iterator<Node> it = this.iterator();
		Iterator<Node> it2 = image2.iterator();
		it.clear();
		affectAux(it, it2);
	}

	/**
	 *
	 *
	 * fonction auxiliaire de affect
	 *
	 * 
	 */

	private void affectAux(Iterator<Node> it, Iterator<Node> it2) {

		if (!it2.isEmpty()) {
			it.addValue(it2.getValue());
			it.goLeft();
			it2.goLeft();
			affectAux(it, it2);
			it.goUp();
			it2.goUp();
			it.goRight();
			it2.goRight();
			affectAux(it, it2);
			it.goUp();
			it2.goUp();
		}

	}

	/**
	 * this devient rotation de image2 à 180videoInvers degrés.
	 *
	 * @param image2 image pour rotation
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void rotate180(AbstractImage image2) {
		Iterator<Node> it = this.iterator();
		Iterator<Node> it2 = image2.iterator();
		it.clear();
		rotate180Aux(it, it2);
	}

	public void rotate180Aux(Iterator<Node> it, Iterator<Node> it2) {
		if (!it2.isEmpty()) {
			it.addValue(it2.getValue());
			it.goLeft();
			it2.goRight();
			rotate180Aux(it, it2);
			it.goUp();
			it2.goUp();
			it.goRight();
			it2.goLeft();
			rotate180Aux(it, it2);
			it.goUp();
			it2.goUp();

		}
	}

	/**
	 * this devient inverse vidéo de this, pixel par pixel.
	 *
	 * @pre !image.isEmpty()
	 */
	@Override
	public void videoInverse() {
		Iterator<Node> it = this.iterator();
		videoInverseAux(it);
	}

	public void videoInverseAux(Iterator<Node> it) {
		if (it.getValue().state == 2) {

			it.goLeft();
			videoInverseAux(it);
			it.goUp();
			it.goRight();
			videoInverseAux(it);
			it.goUp();
		} else if (it.getValue().state == 0) {
			it.setValue(Node.valueOf(1));
		} else {
			it.setValue(Node.valueOf(0));
		}

	}

	/**
	 * this devient image miroir verticale de image2.
	 *
	 * @param image2 image à agrandir
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void mirrorV(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient image miroir horizontale de image2.
	 *
	 * @param image2 image à agrandir
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void mirrorH(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient quart supérieur gauche de image2.
	 *
	 * @param image2 image à agrandir
	 * 
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void zoomIn(AbstractImage image2) {
		Iterator<Node> it = this.iterator();
		Iterator<Node> it2 = image2.iterator();
		it.clear();
		if (it2.getValue().state == 2) {
			it2.goLeft();
			if (it2.getValue().state != 2) {
				it.addValue((it2.getValue()));
			} else {
				it2.goLeft();
				affectAux(it, it2);
			}

		}

	}

	/**
	 * Le quart supérieur gauche de this devient image2, le reste de this devient
	 * éteint.
	 * 
	 * @param image2 image à réduire
	 * @pre !image2.isEmpty()
	 */
	@Override
	public void zoomOut(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient l'intersection de image1 et image2 au sens des pixels allumés.
	 * 
	 * @pre !image1.isEmpty() && !image2.isEmpty()
	 * 
	 * @param image1 premiere image
	 * @param image2 seconde image
	 */
	@Override
	public void intersection(AbstractImage image1, AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
	}

	/**
	 * this devient l'union de image1 et image2 au sens des pixels allumés.
	 * 
	 * @pre !image1.isEmpty() && !image2.isEmpty()
	 * 
	 * @param image1 premiere image
	 * @param image2 seconde image
	 */
	@Override
	public void union(AbstractImage image1, AbstractImage image2) {
		Iterator<Node> it = this.iterator();
		Iterator<Node> it1 = image1.iterator();
		Iterator<Node> it2 = image2.iterator();
		it.clear();
		unionAux(it, it1, it2);
	}

	public void unionAux(Iterator<Node> it, Iterator<Node> it1, Iterator<Node> it2) {
		if (!it1.isEmpty() && !it2.isEmpty()) {
			if (it1.getValue().state == 0 && it2.getValue().state == 0) {
				it.addValue(Node.valueOf(0));
			} else if (it1.getValue().state == 1 || it2.getValue().state == 1) {
				it.addValue(Node.valueOf(1));
			} else if (it1.getValue().state == 2 && it2.getValue().state == 2) {
				it.addValue(Node.valueOf(2));
				it1.goLeft();
				it2.goLeft();
				it.goLeft();
				unionAux(it, it1, it2);
				it1.goUp();
				it2.goUp();
				it.goUp();
				it1.goRight();
				it2.goRight();
				it.goRight();
				unionAux(it, it1, it2);
				it1.goUp();
				it2.goUp();
				it.goUp();
			} else if (it1.getValue().state == 0) {
				affectAux(it, it2);
			} else {
				affectAux(it, it2);
			}
		}
	}

	/**
	 * Attention : cette fonction ne doit pas utiliser la commande isPixelOn
	 * 
	 * @return true si tous les points de la forme (x, x) (avec 0 <= x <= 255)
	 *         sont allumés dans this, false sinon
	 */
	@Override
	public boolean testDiagonal() {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
		return false;
	}

	/**
	 * @param x abscisse du point
	 * @param y ordonnée du point
	 * @pre !this.isEmpty()
	 * @return true, si le point (x, y) est allumé dans this, false sinon
	 */
	@Override
	public boolean isPixelOn(int x, int y) {
		Iterator<Node> it = this.iterator();
		boolean hauteur = true;
		int maxY = 255;
		int maxX = 255;
		int xCompare = 127;
		int yCompare = 127;
		while (it.getValue().state == 2) {
			if (hauteur) {
				if (y < maxY - yCompare) {
					maxY = maxY - yCompare - 1;
					it.goLeft();
				} else {
					it.goRight();
				}
				yCompare = yCompare / 2;
				hauteur = false;
			} else {
				if (x < maxX - xCompare) {
					maxX = maxX - xCompare - 1;
					it.goLeft();
				} else {
					it.goRight();
				}
				xCompare = xCompare / 2;
				hauteur = true;
			}
		}
		return it.getValue().state == 1;

	}

	/**
	 * @param x1 abscisse du premier point
	 * @param y1 ordonnée du premier point
	 * @param x2 abscisse du deuxième point
	 * @param y2 ordonnée du deuxième point
	 * @pre !this.isEmpty()
	 * @return true si les deux points (x1, y1) et (x2, y2) sont représentés par la
	 *         même feuille de this, false sinon
	 */
	@Override
	public boolean sameLeaf(int x1, int y1, int x2, int y2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
		return false;
	}

	/**
	 * @param image2 autre image
	 * @pre !this.isEmpty() && !image2.isEmpty()
	 * @return true si this est incluse dans image2 au sens des pixels allumés false
	 *         sinon
	 */
	@Override
	public boolean isIncludedIn(AbstractImage image2) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("Fonction a ecrire");
		System.out.println("-------------------------------------------------");
		System.out.println();
		return false;
	}
}