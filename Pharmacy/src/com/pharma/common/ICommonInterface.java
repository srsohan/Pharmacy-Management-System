
package com.pharma.common;

import java.util.List;

public interface ICommonInterface<T> {
    public int save(T t);
    public T edit(T t);
    public int delete(T t);
    public T getbyCode(int code);
    public List<T> getAll();
    public int update(T t);
}
