package com.csair.bi.oasearch.service;

import com.csair.bi.oasearch.domain.Document;

/**
 * Created by cloudoo on 2017/5/25.
 */
public interface IDocumentService {

    public boolean index(Document document);
    public boolean update(Document document);
    public boolean delete(Document document);

}
