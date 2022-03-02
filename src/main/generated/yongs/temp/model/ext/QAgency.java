package yongs.temp.model.ext;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAgency is a Querydsl query type for Agency
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAgency extends EntityPathBase<Agency> {

    private static final long serialVersionUID = -48130073L;

    public static final QAgency agency = new QAgency("agency");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QAgency(String variable) {
        super(Agency.class, forVariable(variable));
    }

    public QAgency(Path<? extends Agency> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAgency(PathMetadata metadata) {
        super(Agency.class, metadata);
    }

}

