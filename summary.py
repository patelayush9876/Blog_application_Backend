from flask import Flask, request, jsonify
import nltk
from nltk.tokenize import sent_tokenize
from sklearn.feature_extraction.text import TfidfVectorizer
import numpy as np

# Download necessary NLTK data
nltk.download("punkt")

app = Flask(__name__)

def extract_summary(text, sentence_count=3):
    """Summarizes text using TF-IDF sentence scoring."""
    sentences = sent_tokenize(text)

    if len(sentences) <= sentence_count:
        return " ".join(sentences)  # Return full text if it's too short

    # Convert sentences into TF-IDF matrix
    vectorizer = TfidfVectorizer(stop_words="english")
    sentence_vectors = vectorizer.fit_transform(sentences)

    # Compute sentence importance scores
    sentence_scores = np.array(sentence_vectors.sum(axis=1)).flatten()

    # Rank sentences by importance and select the top ones
    ranked_sentences = [sentences[i] for i in sentence_scores.argsort()[-sentence_count:][::-1]]

    return " ".join(ranked_sentences)

@app.route("/summarize", methods=["POST"])
def summarize():
    data = request.get_json()
    text = data.get("text", "")

    if not text:
        return jsonify({"error": "No text provided"}), 400

    summary = extract_summary(text, sentence_count=3)
    return jsonify({"summary": summary})

if __name__ == "__main__":
    app.run(port=5001)
