package draughts.models;

public class Coordinate {

    private final int row;
    private final int column;
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 7;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isValid() {
        return Coordinate.LOWER_LIMIT <= this.row && 
                this.row <= Coordinate.UPPER_LIMIT && 
                Coordinate.LOWER_LIMIT <= this.column && 
                this.column <= Coordinate.UPPER_LIMIT;
    }

    public boolean isDiagonal(Coordinate coordinate) {
        assert coordinate != null;
        return this.row + this.column == coordinate.row + coordinate.column
                || this.row - this.column == coordinate.row - coordinate.column;
    }

    public int diagonalDistance(Coordinate coordinate) {
        assert coordinate != null;
        return Math.abs(this.row - coordinate.row);
    }

    public Coordinate betweenDiagonal(Coordinate coordinate) {
        assert this.isDiagonal(coordinate);
        assert this.diagonalDistance(coordinate) == 2;
        int rowShift = 1;
        if (coordinate.row - this.row < 0) {
            rowShift = -1;
        }
        int columnShift = 1;
        if (coordinate.column - this.column < 0) {
            columnShift = -1;
        }
        return new Coordinate(this.row + rowShift, this.column + columnShift);
    }

    public boolean isBlack() {
        return (this.row + this.column) % 2 != 0;
    }

    int getRow() {
        return this.row;
    }

    int getColumn() {
        return this.column;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + column;
        result = prime * result + row;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        if (this.column != other.column) {
            return false;
        }
        if (this.row != other.row) {
            return false;
        }
        return true;
    }
}
