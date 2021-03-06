package client.boardGames;

/**
 * A class containing methods to check if one of the players won and fill up the
 * array with null.
 * 
 * @author Adam Szekely, Filip Hudec, Signe Rasmussen, Peter Miodrag Varanic,
 *         Ana Iulia Chifor
 *
 */
public class Count {
	/**
	 * Checks diagonally,vertically and horizontally if there are 3 of the same
	 * object in the array.
	 * 
	 * @param arr
	 *            is a 2 dimensional array containing objects which will be
	 *            checked
	 * @return true if there are 3 "X" or "O" diagonally,vertically or
	 *         horizontally in the array, else false
	 */
	public static <T> boolean isThereThree(T[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (j == 0)
					if ((arr[i][j].equals("X") && arr[i][j + 1].equals("X") && arr[i][j + 2]
							.equals("X"))) {

						return true;
					}
				if (i == 0)
					if (arr[i][j].equals("X") && arr[i + 1][j].equals("X")
							&& arr[i + 2][j].equals("X")) {
						return true;
					}
				if (i == 0 && j == 0) {
					if (arr[i][j].equals("X") && arr[i + 1][j + 1].equals("X")
							&& arr[i + 2][j + 2].equals("X")) {
						return true;
					}
					if (arr[i + 2][j].equals("X")
							&& arr[i + 1][j + 1].equals("X")
							&& arr[i][j + 2].equals("X")) {
						return true;
					}
				}

				if (j == 0)
					if (arr[i][j].equals("O") && arr[i][j + 1].equals("O")
							&& arr[i][j + 2].equals("O")) {
						return true;
					}
				if (i == 0)
					if (arr[i][j].equals("O") && arr[i + 1][j].equals("O")
							&& arr[i + 2][j].equals("O")) {
						return true;
					}
				if (i == 0 && j == 0) {
					if (arr[i][j].equals("O") && arr[i + 1][j + 1].equals("O")
							&& arr[i + 2][j + 2].equals("O")) {
						return true;
					} else if (arr[i + 2][j].equals("O")
							&& arr[i + 1][j + 1].equals("O")
							&& arr[i][j + 2].equals("O")) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Checks if there is a null in the array.
	 * 
	 * @param arr
	 *            is a 2 dimensional array containing objects which will be
	 *            checked
	 * @return true if there is a null in the array, else false
	 */
	public static <T> boolean isThereNull(T[][] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++)
				if (arr[i][j] == null) {
					return true;
				}
		return false;
	}

	/**
	 * Sets all the positions in the array to null.
	 * 
	 * @param arr
	 *            is a 2 dimensional array containing objects which will be
	 *            replaced
	 */
	public static <T> void setToNull(T[][] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++)
				arr[i][j] = null;
	}

	/**
	 * Checks diagonally,vertically and horizontally if there are 5 of the same
	 * object in the array.
	 * 
	 * @param arr
	 *            is a 2 dimensional array containing objects which will be
	 *            checked
	 * @return true if there are 5 "X" or "O" diagonally,vertically or
	 *         horizontally in the array, else false
	 */
	public static <T> boolean isThereFive(T[][] arr) {
		System.out.println("IS THERE FIVE METHOD");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				try {
					if ((arr[i][j] == null || arr[i][j + 1] == null
							|| arr[i][j + 2] == null || arr[i][j + 3] == null || arr[i][j + 4] == null)) {

					} else {
						if ((arr[i][j].equals("X") && arr[i][j + 1].equals("X")
								&& arr[i][j + 2].equals("X")
								&& arr[i][j + 3].equals("X") && arr[i][j + 4]
								.equals("X"))) {

							return true;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
				try {
					if (arr[i][j] == (null) || arr[i + 1][j] == (null)
							|| arr[i + 2][j] == (null)
							|| arr[i + 3][j] == (null)
							|| arr[i + 4][j] == (null)) {
					} else {
						if (arr[i][j].equals("X") && arr[i + 1][j].equals("X")
								&& arr[i + 2][j].equals("X")
								&& arr[i + 3][j].equals("X")
								&& arr[i + 4][j].equals("X")) {
							return true;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
				try {
					if (arr[i][j] == (null) || arr[i + 1][j + 1] == (null)
							|| arr[i + 2][j + 2] == (null)
							|| arr[i + 3][j + 3] == (null)
							|| arr[i + 4][j + 4] == (null)) {

					} else {
						if (arr[i][j].equals("X")
								&& arr[i + 1][j + 1].equals("X")
								&& arr[i + 2][j + 2].equals("X")
								&& arr[i + 3][j + 3].equals("X")
								&& arr[i + 4][j + 4].equals("X")) {
							return true;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
				try {
					if (arr[i][j] == (null) || arr[i - 1][j + 1] == (null)
							|| arr[i - 2][j + 2] == (null)
							|| arr[i - 3][j + 3] == (null)
							|| arr[i - 4][j + 4] == (null)) {

					} else {
						if (arr[i][j].equals("X")
								&& arr[i - 1][j + 1].equals("X")
								&& arr[i - 2][j + 2].equals("X")
								&& arr[i - 3][j + 3].equals("X")
								&& arr[i - 4][j + 4].equals("X")) {
							return true;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}

				try {
					if ((arr[i][j] == null || arr[i][j + 1] == null
							|| arr[i][j + 2] == null || arr[i][j + 3] == null || arr[i][j + 4] == null)) {

					} else {
						if ((arr[i][j].equals("O") && arr[i][j + 1].equals("O")
								&& arr[i][j + 2].equals("O")
								&& arr[i][j + 3].equals("O") && arr[i][j + 4]
								.equals("O"))) {
							return true;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
				try {
					if (arr[i][j] == (null) || arr[i + 1][j] == (null)
							|| arr[i + 2][j] == (null)
							|| arr[i + 3][j] == (null)
							|| arr[i + 4][j] == (null)) {
					} else {
						if (arr[i][j].equals("O") && arr[i + 1][j].equals("O")
								&& arr[i + 2][j].equals("O")
								&& arr[i + 3][j].equals("O")
								&& arr[i + 4][j].equals("O")) {
							return true;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
				try {
					if (arr[i][j] == (null) || arr[i + 1][j + 1] == (null)
							|| arr[i + 2][j + 2] == (null)
							|| arr[i + 3][j + 3] == (null)
							|| arr[i + 4][j + 4] == (null)) {

					} else {
						if (arr[i][j].equals("O")
								&& arr[i + 1][j + 1].equals("O")
								&& arr[i + 2][j + 2].equals("O")
								&& arr[i + 3][j + 3].equals("O")
								&& arr[i + 4][j + 4].equals("O")) {
							return true;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
				try {
					if (arr[i][j] == (null) || arr[i - 1][j + 1] == (null)
							|| arr[i - 2][j + 2] == (null)
							|| arr[i - 3][j + 3] == (null)
							|| arr[i - 4][j + 4] == (null)) {

					} else {
						if (arr[i][j].equals("O")
								&& arr[i - 1][j + 1].equals("O")
								&& arr[i - 2][j + 2].equals("O")
								&& arr[i - 3][j + 3].equals("O")
								&& arr[i - 4][j + 4].equals("O")) {
							return true;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {

				}
			}
		}
		return false;
	}
}
