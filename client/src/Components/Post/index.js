import React, { useEffect, useState } from 'react';

function Post() {
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(false);
    const [postData, setPostData] = useState([]);

    useEffect(() => {
        fetch("/posts")
            .then(res => res.json())
            .then(
                (result) => {
                    setLoading(true);
                    setPostData(result);
                },
                (error) => {
                    setLoading(true);
                    setError(error);
                }
            );
    }, []);

    if (error)
        return <div>error</div>;

    return (
        <div>
            {loading ? (
                postData.map((post) => (
                    <div key={post.id}>
                        <h2>{post.title}</h2>
                        <p>{post.text}</p>
                    </div>
                ))
            ) : (
                <div>Loading...</div>
            )}
        </div>
    );
}

export default Post;
