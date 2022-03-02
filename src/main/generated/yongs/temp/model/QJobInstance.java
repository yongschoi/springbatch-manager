package yongs.temp.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJobInstance is a Querydsl query type for JobInstance
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJobInstance extends EntityPathBase<JobInstance> {

    private static final long serialVersionUID = 1175301789L;

    public static final QJobInstance jobInstance = new QJobInstance("jobInstance");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath key = createString("key");

    public final StringPath name = createString("name");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QJobInstance(String variable) {
        super(JobInstance.class, forVariable(variable));
    }

    public QJobInstance(Path<? extends JobInstance> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJobInstance(PathMetadata metadata) {
        super(JobInstance.class, metadata);
    }

}

