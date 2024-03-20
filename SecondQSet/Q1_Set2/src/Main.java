import java.util.Scanner;

public class Main {
    private static int[][] Output;
    private static int MatSize;

    private static int getMatSize() {
        return MatSize;
    }
    private static void setMatSize(int _output) {
        MatSize = _output;
    }

    private static int[][] getOutput() {
        return Output;
    }
    private static void setOutput(int[][] _output) {
        Output = _output;
    }

    public static void main(String[] args) {
        myInputHandler();
        myTranspose();
        myFlipper();
        myOutputHandler();
    }

    private static void myFlipper() {
        int[][] _tempMat = getOutput();
        int _tmpIndex;

        for (int i = 0; i < getMatSize(); i++) {
            for (int j = 0; j < getMatSize() / 2; j++) {
                _tmpIndex = _tempMat[i][(getMatSize()-1 - j)];
                _tempMat[i][(getMatSize()-1 - j)] = _tempMat[i][j];
                _tempMat[i][j] = _tmpIndex;
            }
        }

        // setOutput(_tempMat);
    }

    private static void myTranspose() {

        int[][] _tempMat = getOutput();

        for (int i = 0; i < getMatSize(); i++) {
            for (int j = i; j < getMatSize(); j++) {
                int _tmpIndex = _tempMat[i][j];
                _tempMat[i][j] = _tempMat[j][i];
                _tempMat[j][i] = _tmpIndex;
            }
        }
       // setOutput(_tempMat);
        
    }

    private static void myOutputHandler() {

        int[][] _tempOutput = getOutput();
        for (int i = 0; i < getMatSize(); i++) {
            for (int j = 0; j < getMatSize(); j++) {
                System.out.print(_tempOutput[i][j]);
                if (j != getMatSize() - 1)
                    System.out.print(",");
                else
                    System.out.print("\n");
            }
        }
    }

    private static void myInputHandler() {
        Scanner _input = new Scanner(System.in);
         setMatSize(_input.nextInt());

        String[] _tempDataSetStr;
        int[][] _tempDataSetInt = new int[getMatSize()][getMatSize()];

        for (int i = 0; i < getMatSize(); ) {
            String _line = _input.nextLine();

            if (_line.length() > 0) {
                _tempDataSetStr = _line.split(",");

                for (int j = 0; j < getMatSize(); j++) {
                    _tempDataSetInt[i][j] = Integer.parseInt(_tempDataSetStr[j]);
                }

                i++;
            }
        }
        _input.close();
        setOutput(_tempDataSetInt);
    }
}
