package yongs.temp.model.ext;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLibrary is a Querydsl query type for Library
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLibrary extends EntityPathBase<Library> {

    private static final long serialVersionUID = -264821479L;

    public static final QLibrary library = new QLibrary("library");

    public final ListPath<Book, QBook> bookList = this.<Book, QBook>createList("bookList", Book.class, QBook.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QLibrary(String variable) {
        super(Library.class, forVariable(variable));
    }

    public QLibrary(Path<? extends Library> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLibrary(PathMetadata metadata) {
        super(Library.class, metadata);
    }

}

