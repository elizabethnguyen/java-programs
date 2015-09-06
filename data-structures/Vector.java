import java.util.Iterator;

public class Vector implements Iterable<Object> 
{

    private static final int DEFAULT_SIZE = 64;
    private static final int GROW_FACTOR = 2;
    private int _maximumSize = DEFAULT_SIZE;
    private int _currentSize = 0;
    private int _trueSize = _maximumSize * 2;
    private Object[] _array;

    public Vector ()
    {
        _array = new Object[_trueSize];
    }

    public Vector (int size)
    {
        if (size < 0) {
            throw new NegativeArraySizeException();
        }
        _maximumSize = size;
        _trueSize = _maximumSize * 2;
        _array = new Object[_trueSize];
    }

    // Basic Element Access
    public Object at (int index)
    {
        if (index >= _maximumSize || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return _array[index];
        }
    }

    public Object front()
    {
        if (_array != null && _maximumSize > 0) {
            return _array[0];
        } else {
            return null;
        }
    }

    public Object back()
    {
        if (_array != null && _maximumSize > 0) {
            return _array[_maximumSize-1];
        } else {
            return null;
        }
    }

    public void put(int index, Object item) // this method will also grow the vector if out of bounds
    {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index >= _maximumSize) {
            if (index < _trueSize) {
                _maximumSize = index+1;
            } else {
                expand(GROW_FACTOR);
            }
        }

        _array[index] = item;
        if (_array[index] == null) {
            _currentSize++;
        }
    }

    public void remove(int index)
    {
        if (index >= _maximumSize || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            _array[index] = null;
        }
    }

    // Defines Iterable
    public Iterator<Object> iterator()
    {
        Iterator<Object> iter = new Iterator<Object>() {
                private int _currentIndex = 0;

                public boolean hasNext()
                {
                    return _currentIndex < _maximumSize;
                }

                public Object next() {

                    return _array[_currentIndex++];
                }

                public void remove()
                {
                    throw new UnsupportedOperationException();
                }

            };
        return iter;
    }

    // Capacity Methods
    public int maxSize()
    {
        return _maximumSize;
    }

    public int size()
    {
        return _currentSize;
    }

    public boolean isEmpty()
    {
        return _currentSize == 0;
    } 

    public boolean isEmpty(int index)
    {
        if (index >= _maximumSize || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return _array[index] == null;
        }
    }

    public void clear()
    {
        for (int index = 0; index < _maximumSize; index++) {
            _array[index] = null;
        }
    }

    // Resizing Methods
    private void expand(int factor)
    {
        _trueSize = (int) _maximumSize * factor;
        Object[] newArray = new Object[_trueSize];

        for (int index = 0; index < _maximumSize; index++) {
            newArray[index] = _array[index];
        }
        _array = newArray;
    }

    public void collapse() // Moves non-null elements towards the front (preserve order)
    {
        int i = 0;
        for (int j = i+1; j < _maximumSize; j++) {
            if (i > _maximumSize-1) {
                break;
            }

            if (_array[i] == null && _array[j] == null) {
                continue;
            } else if (_array[i] != null && _array[j] == null) {
                i++;
            } else if (_array[i] == null && _array[j] != null) {
                _array[i] = _array[j];
                _array[j] = null;
                i++;
                } else if (_array[i] != null && _array[j] != null) {
                i++;
            }
        }
    }

    public void collapseAndShrink() // Safely shrink the array down to exact size
    {
        
    }

    public void truncate() // Will shrink the vector down to specified size - data that is outside the scope will be lost!
    {
        
    }

    // Operations Requiring Resizing
    public void putBack(Object obj)
    {
        assert _maximumSize >= 0;

        if (_maximumSize == 0) {
            _array = new Object[1];
            _maximumSize = 1;
            _trueSize = _maximumSize * GROW_FACTOR;
        } else if (_maximumSize >= _trueSize) {
            expand(GROW_FACTOR);
        }

        _maximumSize++;
        if (obj != null) {
            _currentSize += 1;
            _array[_maximumSize-1] = obj;
            }
    }

}
