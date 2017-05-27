package com.csair.bi.oasearch.service;

import com.csair.bi.oasearch.domain.Document;
import com.csair.bi.es.ElasticSearchFactory;

/**
 * Created by cloudoo on 2017/5/25.
 */
public class DocumentService implements IDocumentService{

    private ElasticSearchFactory elasticSearchFactory;

    @Override
    public boolean index(Document document) {


        return false;
    }

    @Override
    public boolean update(Document document) {
        return false;
    }

    @Override
    public boolean delete(Document document) {
        return false;
    }
}
