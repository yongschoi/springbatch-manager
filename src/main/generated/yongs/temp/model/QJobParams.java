package yongs.temp.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobParams is a Querydsl query type for JobParams
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobParams extends EntityPathBase<JobParams> {

    private static final long serialVersionUID = 1932588430L;

    public static final QJobParams jobParams = new QJobParams("jobParams");

    public final DateTimePath<java.time.LocalDateTime> dateVal = createDateTime("dateVal", java.time.LocalDateTime.class);

    public final NumberPath<Double> doubleVal = createNumber("doubleVal", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identifying = createString("identifying");

    public final StringPath keyName = createString("keyName");

    public final NumberPath<Long> longVal = createNumber("longVal", Long.class);

    public final StringPath stringVal = createString("stringVal");

    public final StringPath typdCd = createString("typdCd");

    public QJobParams(String variable) {
        super(JobParams.class, forVariable(variable));
    }

    public QJobParams(Path<? extends JobParams> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobParams(PathMetadata metadata) {
        super(JobParams.class, metadata);
    }

}

